
#NOW=$(date +"%m-%d-%Y-%H-%M-%S") 

#echo "hiii: $NOW"

#Scoop Import
'''
sqoop import \
--connect jdbc:mysql://localhost:3306/retail_db \
--username root \
--password cloudera \
--table orders --m 1
'''

echo "=============================executing scoop select query=================================="

sqoop eval --connect jdbc:mysql://localhost:3306/retail_db --username root --password cloudera --query "select * from orders where order_id > 10 limit 10"

sqoop eval --connect jdbc:mysql://localhost:3306/retail_db \
 --username root \
 --password cloudera \
 --query "desc orders"

echo "=============================query executed successfully=================================="
