pipeline {

    agent any

        stages {

        stage('Build')    {

            steps {
            sh 'mvn -B -DskipTests=true clean package'

            }

        }


    }

}

