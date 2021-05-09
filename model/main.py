from typing import Optional

from fastapi import FastAPI
from pydantic import BaseModel
from answer import get_answer
from mongo import MongoManager

app = FastAPI()

class Query(BaseModel):
    question: str


@app.get("/")
def read_root():
    return {"Hello": "World"}



@app.post("/kb/{id}")
def find_answer(query: Query):
    db=MongoManager.getInstance()
    ret_kb=db.kbModel.find_one({'kbId':id}) 
    docId=ret_kb['docId'][0] # Assuming document with id=1 to be the one containing text
    ret_doc=db.documentModel.find_one({'docId':docId})
    document=ret_doc['text']
    return get_answer(document,query.question)