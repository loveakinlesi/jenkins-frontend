package com.quarks.test.pipelinefunctions

def call(Map pipelineParams) {
    if (env.DEPLOY_BUILD == 'true') {
        sh "git commit --allow-empty -am 'New Release candidate'"
        sh "git tag -a v\${env.BUILD_NUMBER} -m 'Version \${env.BUILD_NUMBER}'"
        sh "git push origin v\${env.BUILD_NUMBER}"
    }
}