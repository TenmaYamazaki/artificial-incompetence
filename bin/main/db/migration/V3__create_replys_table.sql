CREATE TABLE replys (
    id SERIAL PRIMARY KEY,
    adjective_id INTEGER NOT NULL,
    noun_id INTEGER NOT NULL,
    word VARCHAR(100) NOT NULL
)