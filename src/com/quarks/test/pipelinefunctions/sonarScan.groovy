package com.quarks.test.pipelinefunctions

def call(pipelineParams) {
    if(({ pipelineParams.skipSonarScan } != null && { pipelineParams.skipSonarScan })){
        echo "SKIPPING SONAR ANALYSIS";
    } else {
        echo "Running Sonar analysis...";
    }
}