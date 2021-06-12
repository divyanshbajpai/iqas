from typing import Optional

from fastapi import FastAPI
from pydantic import BaseModel
from answer import get_answer
from mongo import MongoManager
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

origins = [
    "http://localhost.tiangolo.com",
    "https://localhost.tiangolo.com",
    "http://localhost:3000",
    "http://localhost:8080",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)



class Query(BaseModel):
    question: str


@app.get("/")
def read_root():
    return {"Hello": "World"}



@app.post("/kb/{kbId}/doc/{docId}")
def find_answer(kbId: int,docId: int, query: Query):
    db=MongoManager.getInstance()
    ret_kb=db.kbModel.find_one({'kbId':kbId}) 
    doc=ret_kb['docId'][0] # Assuming document with id=1 to be the one containing text
    ret_doc=db.documentModel.find_one({'docId':docId})
    document=ret_doc['text']
    return get_answer(document,query.question)