SELECT distinct l1.num as  ConsecutiveNums
FROM Logs l1
JOIN Logs l2
    ON l2.id = l1.id + 1
    AND l1.num = l2.num
JOIN Logs l3
    ON l3.id = l1.id + 2
    AND l3.num = l1.num;