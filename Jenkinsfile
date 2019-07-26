pipeline {

    agent any

        stages {

        stage('Build')    {

            agent {
            docker {
            image 'maven:3.6.1'
            }
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

