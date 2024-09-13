<script>
    let vote = {
        username: "",
        caption: "",
        pollId: "",
        poll: {
            question: "",
            voteOptions: []
        }
    };

    // Fetch poll details by question
    async function loadPoll() {
        try {
            const response = await fetch(`http://localhost:8080/polls/question/${vote.question}`);
            if (response.ok) {
                const poll = await response.json();
                vote.poll = poll;
                vote.pollId = poll.pollId;
                vote.caption = ""; // Reset selection
            } else {
                console.error('Failed to load poll');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }

    // Create a new vote
    const createVote = async () => {
        console.log('Creating vote with:', vote);
        try {
            const response = await fetch(`http://localhost:8080/votes`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    ...vote,
                    caption: vote.caption
                })
            });
            if (response.ok) {
                console.log('Vote created', await response.json());
                vote = {
                    username: "",
                    caption: "",
                    pollId: "",
                    poll: {
                        question: "",
                        voteOptions: []
                    }
                };
            } else {
                console.error('Failed to create vote');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }
</script>

<div>
    <h2>Vote</h2>
    <input bind:value={vote.username} placeholder="Username"/>
    <input bind:value={vote.question} placeholder="Poll Question"/>

    <button on:click={loadPoll}>Load Poll</button>

    {#if vote.poll.question}
        <h3>{vote.poll.question}</h3>
        {#each vote.poll.voteOptions as option}
            <label>
                <input
                        type="radio"
                        name="voteOption"
                        bind:group={vote.caption}
                        value={option.caption}
                        on:change={() => console.log('Selected value:', vote.caption)}
                />
                {option.caption}
            </label>
        {/each}
        <button on:click={createVote}>Vote</button>
    {/if}
</div>