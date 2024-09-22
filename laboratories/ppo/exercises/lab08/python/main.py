from src.Collection import Collection


words = [
    "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur",
    "adipiscing", "elit", "sed", "do", "eiusmod", "tempor",
    "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua"
]

collection = Collection(words)

collection.filter(lambda word: len(word) < 4) \
    .sort(lambda a, b: a > b) \
    .limit(2)

for word in collection.get():
    print(word)
