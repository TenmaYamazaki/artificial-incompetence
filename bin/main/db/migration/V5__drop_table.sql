DROP TABLE adjectives;
DROP TABLE nouns;
CREATE TABLE adjectives (
    id SERIAL PRIMARY KEY,
    word VARCHAR(100) NOT NULL
);
CREATE TABLE nouns (
    id SERIAL PRIMARY KEY,
    word VARCHAR(100) NOT NULL
);
INSERT INTO adjectives(word) VALUES('〇〇な');
INSERT INTO adjectives(word) VALUES('好きな');
INSERT INTO adjectives(word) VALUES('嫌いな');
INSERT INTO adjectives(word) VALUES('おいしい');
INSERT INTO adjectives(word) VALUES('稀な');
INSERT INTO adjectives(word) VALUES('美しい');
INSERT INTO nouns(word) VALUES('〇〇');
INSERT INTO nouns(word) VALUES('食べ物');
INSERT INTO nouns(word) VALUES('飲み物');
INSERT INTO nouns(word) VALUES('車');
INSERT INTO nouns(word) VALUES('犬');

