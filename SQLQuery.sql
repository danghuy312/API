USE VNPT_API

GO
CREATE TABLE Category(
	id				INT				PRIMARY KEY		
,	name			NVARCHAR(255)
,	status			INT				
,	description		NVARCHAR(255)
)

GO
CREATE TABLE News(
	id				INT				PRIMARY KEY		IDENTITY
,	title			NVARCHAR(255)
,	status			INT				
,	content			TEXT			
,	news_type		INT
,	keyword			INT
,	description		NVARCHAR(255)
,	fillter_type	INT
,	image			NVARCHAR(255)
,	authour			VARCHAR(255)
,	create_date		DATETIME
,	category_id		INT				NOT NULL
,	CONSTRAINT fk_category FOREIGN KEY(category_id) REFERENCES dbo.Category(id)
)


GO
INSERT INTO dbo.Category
	(id, name, status, description)
VALUES
	(33, 'Xa hoi', 0, 'description')
,	(13, 'Tin hot', 0, 'description')
,	(12, 'Van hoa', 0, 'description')
,	(11, 'Doi song', 0, 'description')
,	(2, 'Loai tin hien thi', 0, 'description')
,	(1, 'Danh muc tin tuc', 0, 'description')


GO
INSERT INTO dbo.News
	(image, category_id)
VALUES
	(N'/AvatarCate/33/33_1580811283827.jpg', 33)
,	(N'null', 13)
,	(N'null', 12)
,	(N'null', 11)
,	(N'null', 2)
,	(N'null', 1)