-- 新テーブルの作成
create table public.t_frame (
   frame_id char(20) not null
  , base_flame_flg char(2) not null
  , frame_type char(2) not null
  , title_content_id char(20) not null
  , created_date date not null
  , updated_date date not null
  
)
/


-- 主キーの作成
alter table public.t_frame  add primary key (created_date)
/


-- コメントの作成
comment on table public.t_frame is ''
/

comment on column public.t_frame.updated_date is ''
/

comment on column public.t_frame.frame_id is ''
/

comment on column public.t_frame.base_flame_flg is ''
/

comment on column public.t_frame.frame_type is ''
/

comment on column public.t_frame.title_content_id is ''
/

comment on column public.t_frame.created_date is ''
/

