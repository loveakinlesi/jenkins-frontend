package com.quarks.test.pipelinefunctions

def call(String k8sConfigLocation="kubernetes/development/charts/templates") {
    if (env.DEPLOY_BUILD == 'true') {
         echo "Deploying to Cluster..."
        // withKubeConfig([
        //     credentialsId: env.k8sCredentialsId,
        //     serverUrl: env.k8sServerUrl,
        //     clusterName: env.k8sClusterName,
        //     namespace:  env.namespace
        // ]) {
        //     sh """
        //     sed -i.bak 's#registry.gitlab.com.*#${env.DOCKER_IMAGE}#' '${k8sConfigLocation}/deployment.yml'
        //     kubectl apply -f '${k8sConfigLocation}/'
        //     """
        // }
    }
}