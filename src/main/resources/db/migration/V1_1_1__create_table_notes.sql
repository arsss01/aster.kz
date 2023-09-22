create table todo_list (
                       id uuid primary key,
                       user_id uuid,
                       title varchar,
                       description text,
                       color varchar,
                       note_status varchar,
                       created_at timestamp,
                       updated_at timestamp,
                       remind_at timestamp,
                       expired_at timestamp,
                       foreign key (user_id) references users(id)
);