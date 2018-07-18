
def xxx(){
  echo "loadFile!!"
  
  // https://gist.github.com/rodrigozrusso/67c7a18a30a86012ce7c
  echo "${retort.utils.Utils.class}"
  echo "${retort.utils.Utils.class.classLoader}"
  
  def url = new File('classpath:snakeyaml-1.17.jar').toURL()
  echo "${url}"
  
  retort.utils.Utils.class.classLoader.addURL(url)
  def parser = new org.yaml.snakeyaml.Yaml()
  echo "parser := $parser"
  echo parser.load('key: value \narr:\n- aaa\n-bbb')
}
