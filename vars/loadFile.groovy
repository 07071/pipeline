
def xxx(){
  echo "loadFile!!"
  
  // https://gist.github.com/rodrigozrusso/67c7a18a30a86012ce7c
  echo "${retort.utils.Utils.class}"
  echo "${retort.utils.Utils.class.classLoader}"
  echo "${retort.utils.Utils.class.classLoader.addURL(new File('file.jar').toURL())}"
}
