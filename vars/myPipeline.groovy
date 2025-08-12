def call() {

    pipeline {
        agent none
        stages {
            stage("echo parameters") {
                steps {
                    echo "Hello"                 
                }
            }

        }

    }

}
