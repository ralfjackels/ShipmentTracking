pipeline {

    agent none

        stages {

        stage('Build')    {

            agent {docker {image 'maven:3.3.3'}}

            steps {sh 'mvn -B -DskipTests=true clean package'}
        }


        stage('Test')    {

            agent {docker {image 'maven:3.3.3'}}

            steps {sh 'mvn test'}
        }






        stage ('Deploy'){
            agend {label 'master'}

            steps {
                sh 'docker build -f Dockerfile -t dhl_miniprojekt .'
                sh 'docker run -p 8184:8184 dhl_miniprojekt &'
            }
        }


    }

}

