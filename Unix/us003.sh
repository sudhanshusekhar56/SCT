
awk 'BEGIN{FS = "|" ; OFS = "|"}
{
    sum = $3 + $4 + $5 + $6 + $7
    avg = sum/5.0;
    print $1,$2,avg;
}'