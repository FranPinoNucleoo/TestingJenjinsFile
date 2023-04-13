pipeline{
    agent any
    tools {
        maven 'LocalMaven39'
    }
    stages{
//         stage("Descargar codigo del Git"){
//             steps{
//                 echo "Hemos hecho la descarga del Git"
//                 git branch: 'main', url: 'https://github.com/FranPinoNucleoo/TestingJenjins.git'
//             }
//         }
        stage("Paquetizar con Maven"){
            steps{
                echo "Empezamos la paquetizacion"
                sh "mvn clean package"
            }
        }

        stage("Deploy Tomcat"){
            steps{
                echo "Hacemos un deploy to tomcat"
                deploy adapters: [tomcat9(credentialsId: '1d86ba6a-27df-4960-bb05-e15bb6aed06e', path: '', url: 'http://localhost:8090')], contextPath: null, war: '**/*.war'
            }
        }

    }
}