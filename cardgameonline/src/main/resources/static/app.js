var stompClient = null;

var playingAs = 0;

function connect() {
    var socket = new SockJS('/card-game');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe("/user/queue/errors", function(message) {
            alert("Error " + message.body);
        });

        stompClient.subscribe("/user/queue/reply/receive-self", function(message) {
            receivePlayerView(message);
        });

        stompClient.subscribe("/user/queue/reply/receive-enemy", function(message) {
            receiveEnemyView(message);
        });

        stompClient.subscribe("/user/queue/reply/receive-hand", function(message) {
            receiveHand(message);
        });

        stompClient.subscribe("/user/queue/reply", function(message) {
            alert("Message " + message.body);
        }, function(error) {
            alert("STOMP error " + error);
        });
    });
}

function receiveHand(message) {
    console.log("Received Packet:" + message);
}

function increaseHand() {
    stompClient.send("/app/message/increase-hand", {}, playingAs)
}

// Server sending you YOUR Player Object. (Board, Grave, Hand etc.)
function receivePlayerView(message) {

}

// Server sending you YOUR OPPONENT'S Player Object.
function receiveEnemyView(message) {

}

function disconnect() {
    if (stompClient !== null) {
        stompClient.close();
    }
    console.log("Disconnected");
}

$(document).ready(function(){

    // starting hand
    newCard(document.querySelector("#hand"), 5);

    document.querySelector("#endTurn").onclick = ()=>{
        document.querySelectorAll(".card").forEach((i)=>{
            i.classList.remove("turned");
        });
    };

    document.querySelectorAll(".slot").forEach((i)=>{
        i.ondragover = ()=>{
            if (!i.classList.contains("empty")) {
                const drag = document.querySelector(".dragging");
                if (drag)
                    i.appendChild(drag);
            }
        };

        if (i.classList.contains("deck")) {
            i.onclick = ()=>{
                increaseHand();
                //newCard(document.querySelector("#hand"));
            };
        }

        if (i.classList.contains("shield")) {
            newCard(i);
        }
    });

    connect();
});

function newCard(location, amount) {
    if (!amount) amount = 1;

    for (let i = 0; i < amount; i++) {
        const newElement = document.createElement("div");
        newElement.className = "card";

        newElement.onclick = ()=>{
            if (!newElement.parentNode.classList.contains("shield"))
                newElement.classList.toggle("turned");
        };

        newElement.ondragstart = ()=>{
            newElement.classList.add("dragging");
        };

        newElement.ondragend = ()=>{
            if (newElement.classList.contains("dragging"))
                newElement.classList.remove("dragging");
        };
        location.appendChild(newElement);

        document.querySelectorAll(".grave").forEach((i)=>{
            i.innerHTML = "";
        });
    }
}
