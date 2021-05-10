from pymongo import MongoClient

class MongoManager:
     __instance = None
     @staticmethod 
     def getInstance():
         if MongoManager.__instance == None:
             MongoManager()
         return MongoManager.__instance
     def __init__(self):
        if MongoManager.__instance != None:
            raise Exception("This class is a singleton!")
        else:
            MongoManager.__instance = MongoClient("mongodb://mongoadmin:secret@localhost:27017/user_db?authSource=admin").get_database()