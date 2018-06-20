import retort.utils.logging.Logger
import static retort.utils.Utils.delegateParameters as getParam

/**
 * file list
 * commitMessage
 */
def commit(ret) {
  Logger logger = Logger.getLogger(this)
  def config = getParam(ret)
  
  def command = new StringBuffer()
  
  config.file.each{
      command.append("git add ${it}\n")
  }
  
  command.append("git commit -m '${config.commitMessage}'")

  sh command.toString()
}

/**
 * gitUrl
 * credentialId
 */
def push(ret) {
  Logger logger = Logger.getLogger(this)
  def config = getParam(ret)
  
  
  withCredentials([usernamePassword(credentialsId: config.credentialId, passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USER')]) {
    def command = new StringBuffer('git push ')
     
    def token = config.gitUrl.split('://')
    def protocol = token[0]
    def domain = token[1]
    command.append("${protocol}://${GIT_USER}:${GIT_PASSWORD}@${domain}")
    
    sh command.toString()
  }
  
}
