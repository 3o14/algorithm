function solution(s) {
    return s.split(" ").map(word => (
        word.split("").map((e, i) => {
            return i%2 === 0? e.toUpperCase() : e.toLowerCase();
        }).join("")
    )).join(" ");
}