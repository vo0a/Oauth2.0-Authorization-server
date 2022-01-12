create table IF NOT EXISTS flametalk_db.oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);

insert into flametalk_db.oauth_client_details(client_id, resource_ids, client_secret, scope,
                                              authorized_grant_types, web_server_redirect_uri,
                                              authorities, access_token_validity,
                                              refresh_token_validity, additional_information,
                                              autoapprove)
values ('testClientId', null,
        '{bcrypt}$2a$10$H2oQgFY7qCRHWqkvAV4P6ONy2v74wfr3fQv.xERw3BJYSqh/Gcgrq', 'read,write',
        'authorization_code,refresh_token', 'http://localhost:8080/oauth2/callback', 'ROLE_USER',
        36000, 50000, null, null);

create table IF NOT EXISTS flametalk_db.user
(
    msrl     bigint PRIMARY KEY,
    uid      VARCHAR(50),
    password VARCHAR(100),
    name     VARCHAR(100),
    provider VARCHAR(100),
    stauts   TINYINT
);

create table IF NOT EXISTS oauth_access_token
(
    token_id          VARCHAR(256),
    token LONGVARBINARY,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication    BLOB,
    refresh_token     VARCHAR(256)
);

create table IF NOT EXISTS oauth_refresh_token
(
    token_id       VARCHAR(256),
    token          BLOB,
    authentication BLOB
);

create table IF NOT EXISTS oauth_code
(
    code           VARCHAR(256),
    authentication BLOB
);

create table IF NOT EXISTS oauth_approvals
(
    userId         VARCHAR(256),
    clientId       VARCHAR(256),
    scope          VARCHAR(256),
    status         VARCHAR(10),
    expiresAt      TIMESTAMP,
    lastModifiedAt TIMESTAMP
);