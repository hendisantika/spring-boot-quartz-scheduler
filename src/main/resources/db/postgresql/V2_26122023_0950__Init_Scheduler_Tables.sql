CREATE TABLE schedules
(
    uuid          uuid PRIMARY KEY NOT NULL,
    created_date  TIMESTAMP        NOT NULL,
    created_by    VARCHAR(255)     NOT NULL,
    updated_date  TIMESTAMP,
    updated_by    VARCHAR(255),
    name          VARCHAR(255)     NOT NULL,
    status        VARCHAR(255)     NOT NULL,
    cron          VARCHAR(255)     NOT NULL,
    status_reason VARCHAR(1024) NULL
);
