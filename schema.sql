-- schema.sql

CREATE TABLE users (
                       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,
                       email VARCHAR(200) NOT NULL UNIQUE,
                       password_hash VARCHAR(200),
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       last_login_at TIMESTAMP
);

CREATE TABLE platform_accounts (
                                   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                   user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                                   platform_name VARCHAR(100) NOT NULL,
                                   external_account_id VARCHAR(200) NOT NULL,
                                   display_name VARCHAR(200),
                                   linked_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                   active BOOLEAN NOT NULL DEFAULT TRUE,
                                   api_access_token VARCHAR(500),
                                   api_refresh_token VARCHAR(500),
                                   token_expires_at TIMESTAMP,
                                   UNIQUE (user_id, platform_name, external_account_id)
);

CREATE TABLE games (
                       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       platform_account_id BIGINT NOT NULL REFERENCES platform_accounts(id) ON DELETE CASCADE,
                       external_game_id VARCHAR(200) NOT NULL,
                       title VARCHAR(300) NOT NULL,
                       platform_name VARCHAR(100) NOT NULL,
                       cover_image_url VARCHAR(500),
                       genre VARCHAR(100),
                       release_date DATE,
                       last_played_at TIMESTAMP,
                       total_play_time_minutes BIGINT NOT NULL DEFAULT 0,
                       UNIQUE (platform_account_id, external_game_id)
);

CREATE TABLE achievements (
                              id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              game_id BIGINT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
                              external_achievement_id VARCHAR(200) NOT NULL,
                              name VARCHAR(300) NOT NULL,
                              description VARCHAR(1000),
                              unlocked BOOLEAN NOT NULL DEFAULT FALSE,
                              unlocked_at TIMESTAMP,
                              UNIQUE (game_id, external_achievement_id)
);
