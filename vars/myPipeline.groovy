def call() {

    pipeline {
        agent {
            docker {
                image 'maven:3.9-eclipse-temurin-24'
            }
        }
    
        stages {
            stage('Checkout') {
                steps {
                    // Get some code from a GitHub repository
                     //checkout scmGit(branches: [[name: "master"]], 
                      //extensions: [], 
                      //userRemoteConfigs: [[url: "https://github.com/sutthiphong2005/simple-java-maven-app.git"]])
                      gitJunCheckout(
                           branch: "master",
                           url: "https://github.com/sutthiphong2005/simple-java-maven-app.git"
                      )
    
    
                    // Run Maven on a Unix agent.
                    sh "ls -l"
    
                    // To run Maven on a Windows agent, use
                    // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                }
    
            }
            stage('Build') {
               steps {
                   sh 'mvn -Dmaven.test.failure.ignore=true clean package'
               }
            }
        }
    }


}
