CREATE TABLE post
(
    ID   BIGINT AUTO_INCREMENT,
    NAME VARCHAR(255),
    TITLE TEXT,
    CONTENTS TEXT,
    CREATED_DATE TIMESTAMP NOT NULL,
    MODIFIED_DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE commnet
(
    ID BIGINT AUTO_INCREMENT,
    POST_ID BIGINT NOT NULL,
    COMMENT TEXT NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL,
    MODIFIED_DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (ID)
);