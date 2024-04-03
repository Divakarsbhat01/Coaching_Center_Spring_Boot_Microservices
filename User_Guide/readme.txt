in order to make this application work
Mongo DB
    create a database in mongo db with name users_sb
    port: 27017
    create collection with name user_details
    data has to be in format:
        user_name:"ram@gmail.com"
        user_password: "$2b$12$kI4W/FRwZgLlhHECHict0OvbiagU8WKADnXLyezBzjbfMbu517BVm"
        user_role:"admin"
        user_id:1
    create collection with name user_id_counter
    data has to be in format:
        user_id_counter:1
        counter_name:"user_id_counter"
MysqlDB
    to be updated...

ports:
	config-server: 8088
	api-gateway: 8001
	eureka-server: 8000
	user-details-service: 8002
	security-service: 8003
