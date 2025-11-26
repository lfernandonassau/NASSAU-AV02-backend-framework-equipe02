// Função GET (Buscar dados do Java)
async function buscarMensagem() {
    try {
        // Tenta conectar no Java na porta 8080
        const response = await fetch('http://localhost:8080/api/mensagem');
        
        // Se der erro na conexão, avisa
        if (!response.ok) {
            throw new Error('O Java não respondeu. O servidor está ligado?');
        }
        
        // Pega o texto e coloca na tela
        const data = await response.text();
        document.getElementById('resultado-get').innerText = data;

    } catch (error) {
        alert("Erro: " + error);
        console.error(error);
    }
}

// Função POST (Enviar dados para o Java)
async function enviarDados() {
    const input = document.getElementById("dados-input").value;
    
    // Se o campo estiver vazio, não faz nada
    if (!input) return alert("Digite algo antes de enviar!");

    try {
        const response = await fetch('http://localhost:8080/api/dados', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: input
        });

        const data = await response.text();
        document.getElementById('resultado-post').innerText = data;
        
    } catch (error) {
        alert("Erro ao enviar: " + error);
        console.error(error);
    }
}