CREATE TABLE IF NOT EXISTS Course_Material
(
    course_material_id  NOT NULL PRIMARY KEY,
    course_id INT NOT NULL,
    course_url  VARCHAR(100) NOT NULL
);