drop table t_frame;
create table public.t_frame (
  frame_id character varying(20) not null
  , base_flame_flg character(1) not null
  , frame_type character(2) not null
  , title_content_id character varying(20) not null
  , created_date date not null
  , updated_date date not null
  , primary key (frame_id)
);
drop table r_frames;
create table public.r_frames (
  parent_id character varying(20) not null
  , -- child_id character varying(20) not null
  , created_date date not null
  , updated_date date not null
);

drop table r_frame_content;
create table public.r_frame_content (
  frame_id character varying(20) not null
  , content_id character varying(20) not null
  , created_date date not null
  , updated_date date not null
  , primary key (frame_id, content_id)
);

drop table r_contents;
create table public.r_contents (
  content_relation_id character varying(20) not null
  , from_ids character varying(20) not null
  , to_ids character varying(20) not null
  , line_type character(2) not null
  , text character varying(4000)
  , from_point character(2) not null
  , to_point character(2) not null
  , created_date date not null
  , updated_date date not null
  , primary key (content_relation_id)
);

drop table t_content;
create table public.t_content (
  content_id character varying(20) not null
  , content_type character(2) not null
  , body character varying(4000)
  , created_date date not null
  , updated_date date not null
  , primary key (content_id)
);