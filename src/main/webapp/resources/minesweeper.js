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

let GAME_SCALE ={
	"X_SIZE":9,
	"Y_SIZE":9,
	"MINES_AMOUNT":10
} 

function getMapData() {
	$.ajax(API_SETTINGS).done(function (response) {
		var mapDetail = JSON.parse(response);
		setGameScale(mapDetail);
		generateTable(mapDetail);
	});
}

function setGameScale(mapDetail) {
	GAME_SCALE.Y_SIZE =mapDetail.length;
	GAME_SCALE.X_SIZE =mapDetail[0].length;
	GAME_SCALE.MINES_AMOUNT = 0;
	for (i = 0; i < mapDetail.length; i++) {
		for (j = 0; j < mapDetail[0].length; j++) {
			if(mapDetail[i][j]==9){
				GAME_SCALE.MINES_AMOUNT += 1;
			}
		}
	}
}

async function generateTable(mapDetail) {	
	var mineSweeperCanvas = $("#mine_sweeper");
	mineSweeperCanvas.empty();
	mineSweeperCanvas.append("<table id=\"mine_sweeper_table\" border-collapse: collapse; 	width: 770px; 	word-wrap: break-word; 	table-layout: fixed;>");
	var mineSweeperTable = $("#mine_sweeper_table");


	for (i = 0; i < mapDetail.length; i++) {
		var tableRowInfo = "";
		for (j = 0; j < mapDetail[0].length; j++) {
			tableRowInfo += `<td width="40px"> ${setCellType(mapDetail[i][j])} </td>`;
		}
		mineSweeperTable.append(`<tr> ${tableRowInfo} </tr>`);
	}
}

function setCellType(cellType){
	let imageName = cellType;
	switch(cellType){
		case 0:
			imageName = "empty.png";
			break;
		case 1:
			imageName = "one.png";
			break;
		case 2:
			imageName = "two.png";
			break;
		case 3:
			imageName = "three.png";
			break;
		case 4:
			imageName = "four.png";
			break;
		case 5:
			imageName = "five.png";
			break;
		case 6:
			imageName = "six.png";
			break;
		case 7:
			imageName = "seven.png";
			break;
		case 8:
			imageName = "eight.png";
			break;
		case 9:
			imageName = "answer.png";
			break;
	}
	return `<img src=\"resources/image/${imageName}/">`;
}