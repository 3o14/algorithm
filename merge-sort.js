// 정렬된 left, right 배열을 하나로 합치는 merge 함수
function merge(left, right) {
	// left, right 배열은 이미 정렬되어 있다.
	const result = [];

	while (left.length !== 0 && right.length !== 0) {
		left[0] <= right[0] ? result.push(left.shift()) : result.push(right.shift());	
	}

	return [...result, ...left, ...right];
}

function mergeSort(array) {
    // array 요소가 하나가 남을 때 재귀 종료
	if (array.length === 1) return array;

	// 2로 나누고 내림을 해야 length 가 2일 때도 안전하게 배열을 slice 할 수 있다.
	const middleIndex = Math.floor(array.length / 2); 
	const left = array.slice(0, middleIndex);
	const right = array.slice(middleIndex);

	// 재귀로 계속해서 반으로 나누면서 length 가 1이 될때까지 쪼개고, 
	// 거꾸로 올라오면서 순수한 함수인 merge에 인자로 넣어서 다시 병합되어서 최종값을 리턴한다.
	return merge(mergeSort(left), mergeSort(right));
}


const arr = [4, -1, 0, -8, 0, 8, 91, 2, 3, 4, 98, 911, 21];

const result = mergeSort(arr);
console.log("result: ", result);
// result:  [ -8, -1, 0,  0,  2,  3, 4,  4, 8, 21, 91, 98, 911 ]