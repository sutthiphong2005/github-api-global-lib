def call() {

    pipeline {
        agent none
        stages {
            stage("echo parameters") {
                agent { label "${agentLabel}" }
                steps {
                    echo "Hello"                 
                }
            }

        }

    }

}
