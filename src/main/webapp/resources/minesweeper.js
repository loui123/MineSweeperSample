/**
 * 
 */
const API_SETTINGS = {
	"async": true,
	"crossDomain": true,
	"url": "http://localhost:8080/game",
	"method": "GET",
	"headers": {
		"Cache-Control": "no-cache",
		"Postman-Token": "586cd781-cc26-4b25-834a-cd5aa6498282"
	}
}

const COMPONENTS ={
	"TABLE": "<table id=\"mine_sweeper_table\" border-collapse: collapse; 	width: 770px; 	word-wrap: break-word; 	table-layout: fixed;>",
	"EMPTY_IMAGE": `<img src="resources/image/empty.png" onclick="clickEmptyCell(this)" oncontextmenu="setAnswer(this)">`,
	"ZERO_IMAGE": `<img src="resources/image/zero.png">`,
	"ONE_IMAGE": `<img src="resources/image/one.png">`,
	"TWO_IMAGE": `<img src="resources/image/two.png">`,
	"THREE_IMAGE": `<img src="resources/image/three.png">`,
	"FOUR_IMAGE": `<img src="resources/image/four.png">`,
	"FIVE_IMAGE": `<img src="resources/image/five.png">`,
	"SIX_IMAGE": `<img src="resources/image/six.png">`,
	"SEVEN_IMAGE": `<img src="resources/image/sevevn.png">`,
	"EIGHT_IMAGE": `<img src="resources/image/eight.png">`,
	"ANSWER_IMAGE": `<img src="resources/image/answer.png" oncontextmenu="setAnswer(this)">`,
}

let GAME_SCALE ={
	"X_SIZE":9,
	"Y_SIZE":9,
	"MINES_AMOUNT":10,
	"MAP":[0][0]
} 

function clickEmptyCell(cellImage){
	let td = cellImage.parentNode;
	if(td.innerHTML === COMPONENTS.ANSWER_IMAGE){
		return;
	}
	let mineInfo = getMineInfo(parseInt(td.id.split('_')[1]));
	switch(mineInfo){
		case 0:
			td.innerHTML = COMPONENTS.ZERO_IMAGE;
			break;
		case 1:
			td.innerHTML = COMPONENTS.ONE_IMAGE;
			break;
		case 2:
			td.innerHTML = COMPONENTS.TWO_IMAGE;
			break;
		case 3:
			td.innerHTML = COMPONENTS.THREE_IMAGE;
			break;
		case 4:
			td.innerHTML = COMPONENTS.FOUR_IMAGE;
			break;
		case 5:
			td.innerHTML = COMPONENTS.FIVE_IMAGE;
			break;
		case 6:
			td.innerHTML = COMPONENTS.SIX_IMAGE;
			break;
		case 7:
			td.innerHTML = COMPONENTS.SEVEN_IMAGE;
			break;
		case 8:
			td.innerHTML = COMPONENTS.EIGHT_IMAGE;
			break;
		case 9:
			alert('game over');
			getMapData();
			return; 
	}	
	checkGameWin()
}

function isGameWin(){	
	let answerCount = 0;
	let emptyCount = 0;
	for (i = 0; i < GAME_SCALE.MAP.length; i++) {
		for (j = 0; j <  GAME_SCALE.MAP[0].length; j++) {
			if($(`#table_${toMapValue(i,j)}`).html() === COMPONENTS.ANSWER_IMAGE){
				answerCount += 1;
			}
			if($(`#table_${toMapValue(i,j)}`).html() === COMPONENTS.EMPTY_IMAGE){
				emptyCount += 1;
			}
		}
	}
	if(emptyCount === 0 && answerCount === GAME_SCALE.MINES_AMOUNT){
		return true;
	}
	return false;
}

function checkGameWin(){
	if(isGameWin()){
		alert('Game Win!!!');
		getMapData();
	}
}

function setAnswer(cellImage){
	let td = cellImage.parentNode;
	if(td.innerHTML === COMPONENTS.ANSWER_IMAGE){
		td.innerHTML = COMPONENTS.EMPTY_IMAGE;
	}else if(td.innerHTML === COMPONENTS.EMPTY_IMAGE){
		td.innerHTML = COMPONENTS.ANSWER_IMAGE;
	}
	checkGameWin();
}

function getMapData() {
	$.ajax(API_SETTINGS).done(async function (response) {
		var map = JSON.parse(response);
		await setGameScale(map);
		generateTable();
	});
}

function generateTable() {	
	$("#mine_sweeper").empty();
	$("#mine_sweeper").append(COMPONENTS.TABLE);
	setEmptyCells();
}

function setEmptyCells() {
	for (i = 0; i < GAME_SCALE.MAP.length; i++) {
		let tableRowInfo = "";
		for (j = 0; j <  GAME_SCALE.MAP[0].length; j++) {
			tableRowInfo += `<td width="40px" id="table_${toMapValue(j,i)}">${COMPONENTS.EMPTY_IMAGE}</td>`;
		}
		$("#mine_sweeper_table").append(`<tr> ${tableRowInfo} </tr>`);
	}
}

function toMapValue(x,y){
	return y*GAME_SCALE.X_SIZE+x;
}

function getMineInfo(value){
	let x = value % GAME_SCALE.X_SIZE;
	let y = parseInt(value / GAME_SCALE.X_SIZE);
	return GAME_SCALE.MAP[y][x];
}

function setGameScale(mapArray) {
	GAME_SCALE.Y_SIZE =mapArray.length;
	GAME_SCALE.X_SIZE =mapArray[0].length;
	GAME_SCALE.MINES_AMOUNT = 0;
	GAME_SCALE.MAP = mapArray;
	for (i = 0; i < GAME_SCALE.MAP.length; i++) {
		for (j = 0; j < GAME_SCALE.MAP[0].length; j++) {
			if(GAME_SCALE.MAP[i][j]==9){
				GAME_SCALE.MINES_AMOUNT += 1;
			}
		}
	}
}