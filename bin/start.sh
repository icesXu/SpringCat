#Java程序所在的目录（classes的上一级目录）
APP_HOME=/home/yuzhao.yang/rose-example/WEB-INF
APP_MAINCLASS=com.chen.yuzhao.spiders.DataDeal
#拼凑完整的classpath参数，包括指定lib目录下所有的jar
CLASSPATH=$APP_HOME/classes
for i in "$APP_HOME"/lib/*.jar; do
   CLASSPATH="$CLASSPATH":"$i"
done
java -Xmx4096m -Xms1024m -classpath $CLASSPATH $APP_MAINCLASS
