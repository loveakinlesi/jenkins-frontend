package com.quarks.test.pipelinefunctions

def call() {
    if (env.DOCKER_BUILD == 'true') {
           echo "Pushing to Google Cloud Artifact registry..."
    // withEnv(['GCLOUD_PATH=/var/lib/jenkins/google-cloud-sdk/bin']) {
    //         sh """
    //             \$GCLOUD_PATH/gcloud --version
    //             \$GCLOUD_PATH/gcloud auth activate-service-account --key-file=/var/lib/jenkins/gcr.json
    //             \$GCLOUD_PATH/gcloud config set project \$GCLOUD_PROJECT
    //             \$GCLOUD_PATH/gcloud auth configure-docker europe-west1-docker.pkg.dev
    //             docker tag \$DOCKER_IMAGE europe-west1-docker.pkg.dev/\$GCLOUD_PROJECT/\$repository/\$repository:\$BUILD_NUMBER
    //             docker push europe-west1-docker.pkg.dev/\$GCLOUD_PROJECT/\$repository/\$repository:\$BUILD_NUMBER
    //         """
    //     }
    }
}