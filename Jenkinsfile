pipeline {
    agent any 

    stages {
        stage("Fetch Android Web Search App") {
            steps {
               sh "git clone https://github.com/manguilar22/Android-Search.git"
               
               sh "ls -ltr"
               
            }
        }
        stage("Build Android Web Search App") {
            steps {
                
            
                dir("Android-Search") {
                    sh "pwd"
                    sh "gradle assembleDebug"
                }
                sh "ls -ltr Android-Search/app/build/outputs/apk/debug/app-debug.apk"
                
            }
        }
    }
    
    
    post {
        always {
            archiveArtifacts artifacts: "Android-Search/app/build/outputs/apk/debug/app-debug.apk", fingerprint: true
            sh "rm -rf Android-Search"
        }
    }
    
}    
    

