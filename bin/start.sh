#Java�������ڵ�Ŀ¼��classes����һ��Ŀ¼��
APP_HOME=/home/yuzhao.yang/rose-example/WEB-INF
APP_MAINCLASS=com.chen.yuzhao.spiders.DataDeal
#ƴ��������classpath����������ָ��libĿ¼�����е�jar
CLASSPATH=$APP_HOME/classes
for i in "$APP_HOME"/lib/*.jar; do
   CLASSPATH="$CLASSPATH":"$i"
done
java -Xmx4096m -Xms1024m -classpath $CLASSPATH $APP_MAINCLASS
