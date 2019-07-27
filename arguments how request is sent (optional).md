admin login:
localhost:8080/alogin

{
    "adminid": 1234,			//returns 0 if usename or password is incorrect
    "pwd":"4321"				//returns 1 for correct credentials
}


Employee register
localhost:8080/eregister

{
    "empid": 1234,
    "empname":"nagendra",
    "pwd":"nag4321",
    "mobile":"9844323026"
}

Employee login:
localhost:8080/elogin

{
    "empid": 1234,			//returns 0 if usename or password is incorrect
    "pwd":"nag4321"			//returns 1 for correct credentials
}					//return 2  for blocked user

not approved and non blocked users:
localhost:8080/notapprovedusers

unblock user:
localhost:8080/unblockuser

 {
        "empid": 2345
 }


approveuser:
localhost:8080/approveuser

 {
        "empid": 2345
 }

Block User:
localhost:8080/blockuser

 {
        "empid": 2345
 }

Remove User:
localhost:8080/removeuser

{
        "empid": 2345
}

get all blocked users:
localhost:8080/getallblockedusers

add money:
localhost:8080/addmoney

{
        "empid": 12345,
        "money": 299
}

add new item:
localhost:8080/addnewitem

{
        "itemno": 1003,
        "itemname": "pongal",
        "price":30
}

remove an item:
localhost:8080/removeitem

{
        "itemno": 1003
}

update an item:
localhost:8080/updateitem
{
        "itemno": 1002,
        "itemname": "pongal",
        "price":30
}


active items:
localhost:8080/getallactiveitems

Inactive Items:
localhost:8080/getallinactiveitems

add to menu:
localhost:8080/addtomenu

{
        "itemno": 1005
}

remove from menu:
localhost:8080/removefrommenu

{
        "itemno": 1002
}

check balance:
localhost:8080/checkbalance

{
        "empid":12348
}

order:
localhost:8080/order

 {
        "itemnames": "idly-2,dosa-1",
        "orderprice":50,
        "empid":1234
 }

user current orders:
localhost:8080/userongoingorders

 {
        "empid":12344
 }


user previous orders:
localhost:8080/userpreviousorders

 {
        "empid":1234
 }

ongoing orders:
localhost:8080/ongoingorders

complete order:
localhost:8080/completeorder

{
        "orderid": 1002
}
