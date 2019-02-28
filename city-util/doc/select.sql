-- 通过城市编号获取街道区域信息
SELECT
  t.f_area_code,
  a.`f_name` AS f_area_ame,
  t.`f_code`,
  t.`f_name`
FROM
  ( SELECT * FROM ct_streets WHERE cityCode = 3201 ) t
  LEFT JOIN ct_areas a ON a.`code` = t.areaCode