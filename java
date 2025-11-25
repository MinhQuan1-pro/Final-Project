function upDate(previewPic) {
    console.log("Mouse or focus event triggered!");

    const imgDiv = document.getElementById("image");
    imgDiv.textContent = previewPic.alt;
    imgDiv.style.backgroundImage = `url('${previewPic.src}')`;
}

function undo() {
    console.log("Mouse leave or blur triggered!");

    const imgDiv = document.getElementById("image");
    imgDiv.style.backgroundImage = "url('')";
    imgDiv.textContent = "Hover over an image below to display here.";
}


function setTabFocus() {
    console.log("Page loaded. Setting tabindex...");

    let images = document.querySelectorAll(".preview");

    // add tabindex for keyboard navigation
    for (let i = 0; i < images.length; i++) {
        images[i].setAttribute("tabindex", "0");

        // EVENTS
        images[i].addEventListener("mouseover", function () {
            upDate(this);
        });

        images[i].addEventListener("mouseleave", function () {
            undo();
        });

        images[i].addEventListener("focus", function () {
            upDate(this);
        });

        images[i].addEventListener("blur", function () {
            undo();
        });
    }
}
