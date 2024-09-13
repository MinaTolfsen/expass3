<script>
    let poll = {
        pollId: '',
        username: '',
        question: '',
        publishedAt: new Date().toISOString(),
        validUntil: '',
        voteOptions: []
    };

    let availablePolls = []; // To store list of polls

    // Fetch available polls
    async function loadAvailablePolls() {
        try {
            const response = await fetch('http://localhost:8080/polls');
            if (response.ok) {
                availablePolls = await response.json();
            } else {
                console.error('Failed to load available polls');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }

    // Add a new vote option
    const addVoteOption = () => {
        poll.voteOptions = [...poll.voteOptions, {
            //voteOptionId: '',
            caption: '',
            presentationOrder: poll.voteOptions.length
        }];
    }

    // Create a new poll
    const createPoll = async () => {
        try {
            const response = await fetch('http://localhost:8080/polls', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(poll)
            });

            if (response.ok) {
                const newPoll = await response.json();
                console.log('Poll created:', newPoll);
                // Add the new poll to the list
                availablePolls = [...availablePolls, newPoll];
                // Reset fields after successful creation
                poll = {
                    pollId: '',
                    username: '',
                    question: '',
                    publishedAt: new Date().toISOString(),
                    validUntil: '',
                    voteOptions: []
                };
            } else {
                console.error('Failed to create poll');
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }

    // Load available polls when component mounts
    loadAvailablePolls();
</script>

<div>
    <h2>Create Poll</h2>
    <input bind:value={poll.username} placeholder="Username"/>
    <input bind:value={poll.question} placeholder="Question"/>

    {#each poll.voteOptions as voteOption, i}
        <input bind:value={voteOption[i].caption} placeholder="Vote Option Caption"/>
    {/each}

    <button on:click={addVoteOption}>Add Vote Option</button>
    <button on:click={createPoll}>Create Poll</button>

    <h3>Available Polls</h3>
    {#if availablePolls.length > 0}
        <ul>
            {#each availablePolls as p}
                <li>{p.question}</li>
            {/each}
        </ul>
    {:else}
        <p>No available polls.</p>
    {/if}
</div>
