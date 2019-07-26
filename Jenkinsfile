pipeline {

    agent {
            docker {
            image 'maven:3.3.3'
            }

        stages {

        stage('Build')    {


            }

            steps {
            sh 'mvn -DskipTests clean package'

            }

        }


        stage ('Test') {
            sh 'mvn test'

        }



    }

}

