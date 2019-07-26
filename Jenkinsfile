pipeline {

<<<<<<<<< Temporary merge branch 1
    agent any
=========
    agent none
>>>>>>>>> Temporary merge branch 2

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


        stage ('Test') {
            agent {
                docker {
                    image 'maven:3.3.3'
                }
            }

        steps {
            sh 'mvn test'
            }

        }



    }

}

