#!/usr/bin/env groovy
@Library('utils') _

import groovy.json.JsonOutput
import com.quarks.test.pipelinefunctions.initializeVariables
import com.quarks.test.pipelinefunctions.checkoutMergedBranch
import com.quarks.test.pipelinefunctions.buildDockerImage
import com.quarks.test.pipelinefunctions.checkoutSourceBranch
import com.quarks.test.pipelinefunctions.createGitlabTag
import com.quarks.test.pipelinefunctions.deployToCluster
import com.quarks.test.pipelinefunctions.pushDockerImageToRegistry
import com.quarks.test.pipelinefunctions.pushToGoogleCloudArtifactRegistry
import com.quarks.test.pipelinefunctions.removeLocalDockerImage
import com.quarks.test.pipelinefunctions.runTests
import com.quarks.test.pipelinefunctions.sendWebhook
import com.quarks.test.pipelinefunctions.setupEnvironment
import com.quarks.test.pipelinefunctions.sonarScan

def call(Map pipelineParams) {
    agent any
    tools {
        nodejs 'node18'
    }
    pipeline {
        setupEnvironment().call(pipelineParams)
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    initializeVariables().call()
                }
            }
        }
        stage('Checkout Merged Branch') {
            steps {
                script {
                    checkoutMergedBranch().call()
                }
            }
        }
        stage('Checkout Source Branch') {
            steps {
                script {
                    checkoutSourceBranch().call()
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    runTests().call()
                }
            }
        }
         stage('Run SonarCube Scan') {
            steps {
                script {
                    sonarScan().call()
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    buildDockerImage().call(pipelineParams.dockerImageLocation)
                }
            }
        }
        stage('Push Docker Image to Registry') {
            steps {
                script {
                    pushDockerImageToRegistry().call()
                }
            }
        }
        stage('Remove Local Docker Image') {
            steps {
                script {
                    removeLocalDockerImage().call()
                }
            }
        }
        stage('Deploy to OCI Cluster') {
            steps {
                script {
                    deployToCluster(pipelineParams).call()
                }
            }
        }
        stage('Post Event Webhook') {
            steps {
                script {
                    sendWebhook().call()
                }
            }
        }
    }
}