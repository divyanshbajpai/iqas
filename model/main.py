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
    document="lorem epsum"
    db=MongoManager.getInstance()
    #WIP
    return get_answer(document,query.question)


