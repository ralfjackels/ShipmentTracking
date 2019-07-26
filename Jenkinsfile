pipeline {

    agent any

        stages {

        stage('Build')    {

            steps {
            sh 'mvn -B -DskipTests=true clean package'

            }

        }

        stage('Test') {

                   steps {
                    sh 'mvn test'
                    }
                }

    }

}

