pipeline {
    agent any
     tools {
        maven "3.8.4"
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Compile and Clean') { 
            steps {
                // Run Maven on a Unix agent.
              
                sh "mvn clean compile"
            }
    }
        stage('Test') { 
            steps {
                // Run Maven on a Unix agent.
              
                sh "mvn test"
            }
    }
         stage('deploy') { 
            
            steps {
                sh "mvn package"
            }
        }
         stage('Build Docker image'){
          
            steps {
                echo "Welcome to Expense Tracker"
                sh 'ls'
                sh 'docker build -t  syedraza517/expense-tracker:${BUILD_NUMBER} .'
            }
        }
         stage('Docker Login'){
            
            steps {
                    sh "docker login -u syedraza517 -p Irtaza_99"
                }
            }                
        }

          stage('Docker Push'){
            steps {
                sh 'docker push syedraza517/expense-tracker:${BUILD_NUMBER}'
            }
        }
        stage('Docker deploy'){
            steps {
               
                sh 'docker run -itd -p  8081:8080 syedraza517/expense-tracker:${BUILD_NUMBER}'
            }
        }
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }

        
}
