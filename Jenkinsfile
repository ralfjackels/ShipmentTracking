pipeline {

    agent none

        stages {

        stage('Build')    {

            agent {
                docker {
            image 'maven:3.3.3'
                }
            }
            steps {
            sh 'mvn -DskipTests clean package'

            }
        }

        stage('Test') {
                    agent { docker { image 'maven:3.3.3' } }
                    steps {
                        sh 'mvn test'
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }



    }

}

