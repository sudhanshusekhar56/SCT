awk 'BEGIN{FS = "|" ;count=0}
{
    if($NF == "Active"){
        count ++
    }
}
END{print count?count:"Nothing found..."}
'